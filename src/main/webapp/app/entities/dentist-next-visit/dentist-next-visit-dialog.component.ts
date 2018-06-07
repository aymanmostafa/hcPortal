import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DentistNextVisit } from './dentist-next-visit.model';
import { DentistNextVisitPopupService } from './dentist-next-visit-popup.service';
import { DentistNextVisitService } from './dentist-next-visit.service';

@Component({
    selector: 'jhi-dentist-next-visit-dialog',
    templateUrl: './dentist-next-visit-dialog.component.html'
})
export class DentistNextVisitDialogComponent implements OnInit {

    dentistNextVisit: DentistNextVisit;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private dentistNextVisitService: DentistNextVisitService,
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
        if (this.dentistNextVisit.id !== undefined) {
            this.subscribeToSaveResponse(
                this.dentistNextVisitService.update(this.dentistNextVisit));
        } else {
            this.subscribeToSaveResponse(
                this.dentistNextVisitService.create(this.dentistNextVisit));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<DentistNextVisit>>) {
        result.subscribe((res: HttpResponse<DentistNextVisit>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: DentistNextVisit) {
        this.eventManager.broadcast({ name: 'dentistNextVisitListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-dentist-next-visit-popup',
    template: ''
})
export class DentistNextVisitPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dentistNextVisitPopupService: DentistNextVisitPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.dentistNextVisitPopupService
                    .open(DentistNextVisitDialogComponent as Component, params['id']);
            } else {
                this.dentistNextVisitPopupService
                    .open(DentistNextVisitDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
