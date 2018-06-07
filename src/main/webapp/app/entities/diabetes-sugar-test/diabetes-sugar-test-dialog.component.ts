import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DiabetesSugarTest } from './diabetes-sugar-test.model';
import { DiabetesSugarTestPopupService } from './diabetes-sugar-test-popup.service';
import { DiabetesSugarTestService } from './diabetes-sugar-test.service';

@Component({
    selector: 'jhi-diabetes-sugar-test-dialog',
    templateUrl: './diabetes-sugar-test-dialog.component.html'
})
export class DiabetesSugarTestDialogComponent implements OnInit {

    diabetesSugarTest: DiabetesSugarTest;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private diabetesSugarTestService: DiabetesSugarTestService,
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
        if (this.diabetesSugarTest.id !== undefined) {
            this.subscribeToSaveResponse(
                this.diabetesSugarTestService.update(this.diabetesSugarTest));
        } else {
            this.subscribeToSaveResponse(
                this.diabetesSugarTestService.create(this.diabetesSugarTest));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<DiabetesSugarTest>>) {
        result.subscribe((res: HttpResponse<DiabetesSugarTest>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: DiabetesSugarTest) {
        this.eventManager.broadcast({ name: 'diabetesSugarTestListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-diabetes-sugar-test-popup',
    template: ''
})
export class DiabetesSugarTestPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private diabetesSugarTestPopupService: DiabetesSugarTestPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.diabetesSugarTestPopupService
                    .open(DiabetesSugarTestDialogComponent as Component, params['id']);
            } else {
                this.diabetesSugarTestPopupService
                    .open(DiabetesSugarTestDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
