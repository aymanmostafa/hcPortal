import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsBloodPressure } from './vs-blood-pressure.model';
import { VsBloodPressurePopupService } from './vs-blood-pressure-popup.service';
import { VsBloodPressureService } from './vs-blood-pressure.service';

@Component({
    selector: 'jhi-vs-blood-pressure-delete-dialog',
    templateUrl: './vs-blood-pressure-delete-dialog.component.html'
})
export class VsBloodPressureDeleteDialogComponent {

    vsBloodPressure: VsBloodPressure;

    constructor(
        private vsBloodPressureService: VsBloodPressureService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.vsBloodPressureService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vsBloodPressureListModification',
                content: 'Deleted an vsBloodPressure'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vs-blood-pressure-delete-popup',
    template: ''
})
export class VsBloodPressureDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsBloodPressurePopupService: VsBloodPressurePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vsBloodPressurePopupService
                .open(VsBloodPressureDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
