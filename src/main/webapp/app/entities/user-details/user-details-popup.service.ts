import { Injectable, Component } from '@angular/core';
import { Router } from '@angular/router';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { HttpResponse } from '@angular/common/http';
import { UserDetails } from './user-details.model';
import { UserDetailsService } from './user-details.service';

@Injectable()
export class UserDetailsPopupService {
    private ngbModalRef: NgbModalRef;

    constructor(
        private modalService: NgbModal,
        private router: Router,
        private userDetailsService: UserDetailsService

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
                this.userDetailsService.find(id)
                    .subscribe((userDetailsResponse: HttpResponse<UserDetails>) => {
                        const userDetails: UserDetails = userDetailsResponse.body;
                        if (userDetails.birthdate) {
                            userDetails.birthdate = {
                                year: userDetails.birthdate.getFullYear(),
                                month: userDetails.birthdate.getMonth() + 1,
                                day: userDetails.birthdate.getDate()
                            };
                        }
                        if (userDetails.resetdate) {
                            userDetails.resetdate = {
                                year: userDetails.resetdate.getFullYear(),
                                month: userDetails.resetdate.getMonth() + 1,
                                day: userDetails.resetdate.getDate()
                            };
                        }
                        this.ngbModalRef = this.userDetailsModalRef(component, userDetails);
                        resolve(this.ngbModalRef);
                    });
            } else {
                // setTimeout used as a workaround for getting ExpressionChangedAfterItHasBeenCheckedError
                setTimeout(() => {
                    this.ngbModalRef = this.userDetailsModalRef(component, new UserDetails());
                    resolve(this.ngbModalRef);
                }, 0);
            }
        });
    }

    userDetailsModalRef(component: Component, userDetails: UserDetails): NgbModalRef {
        const modalRef = this.modalService.open(component, { size: 'lg', backdrop: 'static'});
        modalRef.componentInstance.userDetails = userDetails;
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
