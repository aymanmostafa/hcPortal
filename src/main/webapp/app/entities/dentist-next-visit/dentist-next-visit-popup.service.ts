import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { DentistNextVisit } from './dentist-next-visit.model';
import { DentistNextVisitService } from './dentist-next-visit.service';

@Injectable()
export class DentistNextVisitPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private dentistNextVisitService: DentistNextVisitService

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
                this.dentistNextVisitService.find(id)
                    .subscribe((dentistNextVisitResponse: HttpResponse<DentistNextVisit>) => {
                        const dentistNextVisit: DentistNextVisit = dentistNextVisitResponse.body;
                        if (dentistNextVisit.measurmentdate) {
                            dentistNextVisit.measurmentdate = {
                                year: dentistNextVisit.measurmentdate.getFullYear(),
                                month: dentistNextVisit.measurmentdate.getMonth() + 1,
                                day: dentistNextVisit.measurmentdate.getDate()
                            };
                        }
                        this.ngbModalRef = this.dentistNextVisitModalRef(component, dentistNextVisit);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.dentistNextVisitModalRef(component, new DentistNextVisit());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    dentistNextVisitModalRef(component: Component, dentistNextVisit: DentistNextVisit): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.dentistNextVisit = dentistNextVisit;
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
