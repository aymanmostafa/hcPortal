import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { BloodTest } from './blood-test.model';
import { BloodTestPopupService } from './blood-test-popup.service';
import { BloodTestService } from './blood-test.service';

@Component({
    selector: 'jhi-blood-test-dialog',
    templateUrl: './blood-test-dialog.component.html'
})
export class BloodTestDialogComponent implements OnInit {

    bloodTest: BloodTest;
    isSaving: boolean;
    measurmentdateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private bloodTestService: BloodTestService,
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
        if (this.bloodTest.id !== undefined) {
            this.subscribeToSaveResponse(
                this.bloodTestService.update(this.bloodTest));
        } else {
            this.subscribeToSaveResponse(
                this.bloodTestService.create(this.bloodTest));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<BloodTest>>) {
        result.subscribe((res: HttpResponse<BloodTest>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: BloodTest) {
        this.eventManager.broadcast({ name: 'bloodTestListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-blood-test-popup',
    template: ''
})
export class BloodTestPopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private bloodTestPopupService: BloodTestPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.bloodTestPopupService
                    .open(BloodTestDialogComponent as Component, params['id']);
            } else {
                this.bloodTestPopupService
                    .open(BloodTestDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
