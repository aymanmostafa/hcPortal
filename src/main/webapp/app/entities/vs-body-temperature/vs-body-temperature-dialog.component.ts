import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsBodyTemperature } from './vs-body-temperature.model';
import { VsBodyTemperaturePopupService } from './vs-body-temperature-popup.service';
import { VsBodyTemperatureService } from './vs-body-temperature.service';

@Component({
    selector: 'jhi-vs-body-temperature-dialog',
    templateUrl: './vs-body-temperature-dialog.component.html'
})
export class VsBodyTemperatureDialogComponent implements OnInit {

    vsBodyTemperature: VsBodyTemperature;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private vsBodyTemperatureService: VsBodyTemperatureService,
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
        if (this.vsBodyTemperature.id !== undefined) {
            this.subscribeToSaveResponse(
                this.vsBodyTemperatureService.update(this.vsBodyTemperature));
        } else {
            this.subscribeToSaveResponse(
                this.vsBodyTemperatureService.create(this.vsBodyTemperature));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VsBodyTemperature>>) {
        result.subscribe((res: HttpResponse<VsBodyTemperature>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VsBodyTemperature) {
        this.eventManager.broadcast({ name: 'vsBodyTemperatureListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-vs-body-temperature-popup',
    template: ''
})
export class VsBodyTemperaturePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsBodyTemperaturePopupService: VsBodyTemperaturePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.vsBodyTemperaturePopupService
                    .open(VsBodyTemperatureDialogComponent as Component, params['id']);
            } else {
                this.vsBodyTemperaturePopupService
                    .open(VsBodyTemperatureDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
