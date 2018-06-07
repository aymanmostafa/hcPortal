import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { MenstrualCycle } from './menstrual-cycle.model';
import { MenstrualCyclePopupService } from './menstrual-cycle-popup.service';
import { MenstrualCycleService } from './menstrual-cycle.service';

@Component({
    selector: 'jhi-menstrual-cycle-dialog',
    templateUrl: './menstrual-cycle-dialog.component.html'
})
export class MenstrualCycleDialogComponent implements OnInit {

    menstrualCycle: MenstrualCycle;
    isSaving: boolean;
    startDateDp: any;
    endDateDp: any;

    constructor(
        public activeModal: NgbActiveModal,
        private menstrualCycleService: MenstrualCycleService,
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
        if (this.menstrualCycle.id !== undefined) {
            this.subscribeToSaveResponse(
                this.menstrualCycleService.update(this.menstrualCycle));
        } else {
            this.subscribeToSaveResponse(
                this.menstrualCycleService.create(this.menstrualCycle));
        }
    }

    private subscribeToSaveResponse(result: Observable<HttpResponse<MenstrualCycle>>) {
        result.subscribe((res: HttpResponse<MenstrualCycle>) =>
            this.onSaveSuccess(res.body), (res: HttpErrorResponse) => this.onSaveError());
    }

    private onSaveSuccess(result: MenstrualCycle) {
        this.eventManager.broadcast({ name: 'menstrualCycleListModification', content: 'OK'});
        this.isSaving = false;
        this.activeModal.dismiss(result);
    }

    private onSaveError() {
        this.isSaving = false;
    }
}

@Component({
    selector: 'jhi-menstrual-cycle-popup',
    template: ''
})
export class MenstrualCyclePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private menstrualCyclePopupService: MenstrualCyclePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            if ( params['id'] ) {
                this.menstrualCyclePopupService
                    .open(MenstrualCycleDialogComponent as Component, params['id']);
            } else {
                this.menstrualCyclePopupService
                    .open(MenstrualCycleDialogComponent as Component);
            }
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
