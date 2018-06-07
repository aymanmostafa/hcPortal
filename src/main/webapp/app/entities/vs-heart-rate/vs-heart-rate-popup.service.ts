import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { VsHeartRate } from './vs-heart-rate.model';
import { VsHeartRateService } from './vs-heart-rate.service';

@Injectable()
export class VsHeartRatePopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private vsHeartRateService: VsHeartRateService

    ) {
        this.ngbModalRef = null;
    }

    open(component: Component, id?: number | any): Promise<NgbModalRef> {
        return new Promise<NgbModalRef>((resolve, reject) => {
            const isOpen = this.ngbModalRef !== null;
            if (isOpen) {
                resolve(this.ngbModalRef);
            }

            if (id) {
                this.vsHeartRateService.find(id)
                    .subscribe((vsHeartRateResponse: HttpResponse<VsHeartRate>) => {
                        const vsHeartRate: VsHeartRate = vsHeartRateResponse.body;
                        if (vsHeartRate.measurmentdate) {
                            vsHeartRate.measurmentdate = {
                                year: vsHeartRate.measurmentdate.getFullYear(),
                                month: vsHeartRate.measurmentdate.getMonth() + 1,
                                day: vsHeartRate.measurmentdate.getDate()
                            };
                        }
                        this.ngbModalRef = this.vsHeartRateModalRef(component, vsHeartRate);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.vsHeartRateModalRef(component, new VsHeartRate());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    vsHeartRateModalRef(component: Component, vsHeartRate: VsHeartRate): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.vsHeartRate = vsHeartRate;
        modalRef.result.then((result) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        }, (reason) => {
            this.router.navigate([{ outlets: { popup: null }}], { replaceUrl: true, queryParamsHandling: 'merge' });
            this.ngbModalRef = null;
        });
        return modalRef;
    }
}
