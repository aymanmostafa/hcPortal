import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsRespiratoryRate } from './vs-respiratory-rate.model';
import { VsRespiratoryRatePopupService } from './vs-respiratory-rate-popup.service';
import { VsRespiratoryRateService } from './vs-respiratory-rate.service';

@Component({
    selector: 'jhi-vs-respiratory-rate-delete-dialog',
    templateUrl: './vs-respiratory-rate-delete-dialog.component.html'
})
export class VsRespiratoryRateDeleteDialogComponent {

    vsRespiratoryRate: VsRespiratoryRate;

    constructor(
        private vsRespiratoryRateService: VsRespiratoryRateService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.vsRespiratoryRateService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vsRespiratoryRateListModification',
                content: 'Deleted an vsRespiratoryRate'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vs-respiratory-rate-delete-popup',
    template: ''
})
export class VsRespiratoryRateDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsRespiratoryRatePopupService: VsRespiratoryRatePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vsRespiratoryRatePopupService
                .open(VsRespiratoryRateDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
