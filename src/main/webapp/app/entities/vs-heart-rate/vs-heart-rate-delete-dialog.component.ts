import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsHeartRate } from './vs-heart-rate.model';
import { VsHeartRatePopupService } from './vs-heart-rate-popup.service';
import { VsHeartRateService } from './vs-heart-rate.service';

@Component({
    selector: 'jhi-vs-heart-rate-delete-dialog',
    templateUrl: './vs-heart-rate-delete-dialog.component.html'
})
export class VsHeartRateDeleteDialogComponent {

    vsHeartRate: VsHeartRate;

    constructor(
        private vsHeartRateService: VsHeartRateService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.vsHeartRateService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vsHeartRateListModification',
                content: 'Deleted an vsHeartRate'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vs-heart-rate-delete-popup',
    template: ''
})
export class VsHeartRateDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsHeartRatePopupService: VsHeartRatePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vsHeartRatePopupService
                .open(VsHeartRateDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
