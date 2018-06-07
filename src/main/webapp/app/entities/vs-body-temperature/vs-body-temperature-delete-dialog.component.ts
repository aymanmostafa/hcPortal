import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { VsBodyTemperature } from './vs-body-temperature.model';
import { VsBodyTemperaturePopupService } from './vs-body-temperature-popup.service';
import { VsBodyTemperatureService } from './vs-body-temperature.service';

@Component({
    selector: 'jhi-vs-body-temperature-delete-dialog',
    templateUrl: './vs-body-temperature-delete-dialog.component.html'
})
export class VsBodyTemperatureDeleteDialogComponent {

    vsBodyTemperature: VsBodyTemperature;

    constructor(
        private vsBodyTemperatureService: VsBodyTemperatureService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.vsBodyTemperatureService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'vsBodyTemperatureListModification',
                content: 'Deleted an vsBodyTemperature'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-vs-body-temperature-delete-popup',
    template: ''
})
export class VsBodyTemperatureDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private vsBodyTemperaturePopupService: VsBodyTemperaturePopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.vsBodyTemperaturePopupService
                .open(VsBodyTemperatureDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
