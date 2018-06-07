import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { MenstrualCycle } from './menstrual-cycle.model';
import { MenstrualCycleService } from './menstrual-cycle.service';

@Injectable()
export class MenstrualCyclePopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private menstrualCycleService: MenstrualCycleService

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
                this.menstrualCycleService.find(id)
                    .subscribe((menstrualCycleResponse: HttpResponse<MenstrualCycle>) => {
                        const menstrualCycle: MenstrualCycle = menstrualCycleResponse.body;
                        if (menstrualCycle.startDate) {
                            menstrualCycle.startDate = {
                                year: menstrualCycle.startDate.getFullYear(),
                                month: menstrualCycle.startDate.getMonth() + 1,
                                day: menstrualCycle.startDate.getDate()
                            };
                        }
                        if (menstrualCycle.endDate) {
                            menstrualCycle.endDate = {
                                year: menstrualCycle.endDate.getFullYear(),
                                month: menstrualCycle.endDate.getMonth() + 1,
                                day: menstrualCycle.endDate.getDate()
                            };
                        }
                        this.ngbModalRef = this.menstrualCycleModalRef(component, menstrualCycle);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.menstrualCycleModalRef(component, new MenstrualCycle());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    menstrualCycleModalRef(component: Component, menstrualCycle: MenstrualCycle): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.menstrualCycle = menstrualCycle;
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
