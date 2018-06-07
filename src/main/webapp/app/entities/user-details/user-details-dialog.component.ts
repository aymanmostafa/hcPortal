import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { UserDetails } from './user-details.model';
import { UserDetailsPopupService } from './user-details-popup.service';
import { UserDetailsService } from './user-details.service';

@Component({
    selector: 'jhi-user-details-dialog',
    templateUrl: './user-details-dialog.component.html'
})
export class UserDetailsDialogComponent implements OnInit {

    userDetails: UserDetails;
    isSaving: boolean;
    birthdateDp: any;
    resetdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private userDetailsService: UserDetailsService,
        private eventManager: JhiEventManager
    ) {
    }

    ngOnInit() {
        this.isSaving = false;
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    save() {
        this.isSaving = true;
        if (this.userDetails.id !== undefined) {
            this.subscribeToSaveResponse(
                this.userDetailsService.update(this.userDetails));
        } else {
            this.subscribeToSaveResponse(
                this.userDetailsService.create(this.userDetails));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<UserDetails>>) {
        result.subscribe((res: HttpResponse<UserDetails>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: UserDetails) {
        this.eventManager.broadcast({ name: 'userDetailsListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-user-details-popup',
    template: ''
})
export class UserDetailsPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private userDetailsPopupService: UserDetailsPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.userDetailsPopupService
                    .open(UserDetailsDialogComponent as Component, params['id']);
            } else {
                this.userDetailsPopupService
                    .open(UserDetailsDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
