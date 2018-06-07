import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsSpo2 } from './vs-spo-2.model';
import { VsSpo2PopupService } from './vs-spo-2-popup.service';
import { VsSpo2Service } from './vs-spo-2.service';

@Component({
    selector: 'jhi-vs-spo-2-dialog',
    templateUrl: './vs-spo-2-dialog.component.html'
})
export class VsSpo2DialogComponent implements OnInit {

    vsSpo2: VsSpo2;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private vsSpo2Service: VsSpo2Service,
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
        if (this.vsSpo2.id !== undefined) {
            this.subscribeToSaveResponse(
                this.vsSpo2Service.update(this.vsSpo2));
        } else {
            this.subscribeToSaveResponse(
                this.vsSpo2Service.create(this.vsSpo2));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<VsSpo2>>) {
        result.subscribe((res: HttpResponse<VsSpo2>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: VsSpo2) {
        this.eventManager.broadcast({ name: 'vsSpo2ListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-vs-spo-2-popup',
    template: ''
})
export class VsSpo2PopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsSpo2PopupService: VsSpo2PopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.vsSpo2PopupService
                    .open(VsSpo2DialogComponent as Component, params['id']);
            } else {
                this.vsSpo2PopupService
                    .open(VsSpo2DialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
