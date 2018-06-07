import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { BloodTest } from './blood-test.model';
import { BloodTestService } from './blood-test.service';

@Injectable()
export class BloodTestPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private bloodTestService: BloodTestService

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
                this.bloodTestService.find(id)
                    .subscribe((bloodTestResponse: HttpResponse<BloodTest>) => {
                        const bloodTest: BloodTest = bloodTestResponse.body;
                        if (bloodTest.measurmentdate) {
                            bloodTest.measurmentdate = {
                                year: bloodTest.measurmentdate.getFullYear(),
                                month: bloodTest.measurmentdate.getMonth() + 1,
                                day: bloodTest.measurmentdate.getDate()
                            };
                        }
                        this.ngbModalRef = this.bloodTestModalRef(component, bloodTest);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.bloodTestModalRef(component, new BloodTest());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    bloodTestModalRef(component: Component, bloodTest: BloodTest): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.bloodTest = bloodTest;
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
