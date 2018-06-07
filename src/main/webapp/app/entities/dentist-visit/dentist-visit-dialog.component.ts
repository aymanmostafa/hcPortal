import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DentistVisit } from './dentist-visit.model';
import { DentistVisitPopupService } from './dentist-visit-popup.service';
import { DentistVisitService } from './dentist-visit.service';

@Component({
    selector: 'jhi-dentist-visit-dialog',
    templateUrl: './dentist-visit-dialog.component.html'
})
export class DentistVisitDialogComponent implements OnInit {

    dentistVisit: DentistVisit;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private dentistVisitService: DentistVisitService,
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
        if (this.dentistVisit.id !== undefined) {
            this.subscribeToSaveResponse(
                this.dentistVisitService.update(this.dentistVisit));
        } else {
            this.subscribeToSaveResponse(
                this.dentistVisitService.create(this.dentistVisit));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<DentistVisit>>) {
        result.subscribe((res: HttpResponse<DentistVisit>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: DentistVisit) {
        this.eventManager.broadcast({ name: 'dentistVisitListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-dentist-visit-popup',
    template: ''
})
export class DentistVisitPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dentistVisitPopupService: DentistVisitPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.dentistVisitPopupService
                    .open(DentistVisitDialogComponent as Component, params['id']);
            } else {
                this.dentistVisitPopupService
                    .open(DentistVisitDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
