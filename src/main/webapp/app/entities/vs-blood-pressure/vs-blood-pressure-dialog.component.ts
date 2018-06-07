import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsBloodPressure } from './vs-blood-pressure.model';
import { VsBloodPressurePopupService } from './vs-blood-pressure-popup.service';
import { VsBloodPressureService } from './vs-blood-pressure.service';

@Component({
    selector: 'jhi-vs-blood-pressure-dialog',
    templateUrl: './vs-blood-pressure-dialog.component.html'
})
export class VsBloodPressureDialogComponent implements OnInit {

    vsBloodPressure: VsBloodPressure;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private vsBloodPressureService: VsBloodPressureService,
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
        if (this.vsBloodPressure.id !== undefined) {
            this.subscribeToSaveResponse(
                this.vsBloodPressureService.update(this.vsBloodPressure));
        } else {
            this.subscribeToSaveResponse(
                this.vsBloodPressureService.create(this.vsBloodPressure));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VsBloodPressure>>) {
        result.subscribe((res: HttpResponse<VsBloodPressure>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VsBloodPressure) {
        this.eventManager.broadcast({ name: 'vsBloodPressureListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-vs-blood-pressure-popup',
    template: ''
})
export class VsBloodPressurePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsBloodPressurePopupService: VsBloodPressurePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.vsBloodPressurePopupService
                    .open(VsBloodPressureDialogComponent as Component, params['id']);
            } else {
                this.vsBloodPressurePopupService
                    .open(VsBloodPressureDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
