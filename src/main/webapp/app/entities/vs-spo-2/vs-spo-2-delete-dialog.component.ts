import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsSpo2 } from './vs-spo-2.model';
import { VsSpo2PopupService } from './vs-spo-2-popup.service';
import { VsSpo2Service } from './vs-spo-2.service';

@Component({
    selector: 'jhi-vs-spo-2-delete-dialog',
    templateUrl: './vs-spo-2-delete-dialog.component.html'
})
export class VsSpo2DeleteDialogComponent {

    vsSpo2: VsSpo2;

    constructor(
        private vsSpo2Service: VsSpo2Service,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.vsSpo2Service.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vsSpo2ListModification',
                content: 'Deleted an vsSpo2'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vs-spo-2-delete-popup',
    template: ''
})
export class VsSpo2DeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsSpo2PopupService: VsSpo2PopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vsSpo2PopupService
                .open(VsSpo2DeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
