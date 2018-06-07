import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { MenstrualCycle } from './menstrual-cycle.model';
import { MenstrualCyclePopupService } from './menstrual-cycle-popup.service';
import { MenstrualCycleService } from './menstrual-cycle.service';

@Component({
    selector: 'jhi-menstrual-cycle-delete-dialog',
    templateUrl: './menstrual-cycle-delete-dialog.component.html'
})
export class MenstrualCycleDeleteDialogComponent {

    menstrualCycle: MenstrualCycle;

    constructor(
        private menstrualCycleService: MenstrualCycleService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.menstrualCycleService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'menstrualCycleListModification',
                content: 'Deleted an menstrualCycle'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-menstrual-cycle-delete-popup',
    template: ''
})
export class MenstrualCycleDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private menstrualCyclePopupService: MenstrualCyclePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.menstrualCyclePopupService
                .open(MenstrualCycleDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
