import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsRespiratoryRate } from './vs-respiratory-rate.model';
import { VsRespiratoryRatePopupService } from './vs-respiratory-rate-popup.service';
import { VsRespiratoryRateService } from './vs-respiratory-rate.service';

@Component({
    selector: 'jhi-vs-respiratory-rate-dialog',
    templateUrl: './vs-respiratory-rate-dialog.component.html'
})
export class VsRespiratoryRateDialogComponent implements OnInit {

    vsRespiratoryRate: VsRespiratoryRate;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private vsRespiratoryRateService: VsRespiratoryRateService,
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
        if (this.vsRespiratoryRate.id !== undefined) {
            this.subscribeToSaveResponse(
                this.vsRespiratoryRateService.update(this.vsRespiratoryRate));
        } else {
            this.subscribeToSaveResponse(
                this.vsRespiratoryRateService.create(this.vsRespiratoryRate));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VsRespiratoryRate>>) {
        result.subscribe((res: HttpResponse<VsRespiratoryRate>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VsRespiratoryRate) {
        this.eventManager.broadcast({ name: 'vsRespiratoryRateListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-vs-respiratory-rate-popup',
    template: ''
})
export class VsRespiratoryRatePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsRespiratoryRatePopupService: VsRespiratoryRatePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.vsRespiratoryRatePopupService
                    .open(VsRespiratoryRateDialogComponent as Component, params['id']);
            } else {
                this.vsRespiratoryRatePopupService
                    .open(VsRespiratoryRateDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
