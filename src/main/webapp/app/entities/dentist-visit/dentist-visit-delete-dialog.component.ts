import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DentistVisit } from './dentist-visit.model';
import { DentistVisitPopupService } from './dentist-visit-popup.service';
import { DentistVisitService } from './dentist-visit.service';

@Component({
    selector: 'jhi-dentist-visit-delete-dialog',
    templateUrl: './dentist-visit-delete-dialog.component.html'
})
export class DentistVisitDeleteDialogComponent {

    dentistVisit: DentistVisit;

    constructor(
        private dentistVisitService: DentistVisitService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.dentistVisitService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'dentistVisitListModification',
                content: 'Deleted an dentistVisit'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-dentist-visit-delete-popup',
    template: ''
})
export class DentistVisitDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dentistVisitPopupService: DentistVisitPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.dentistVisitPopupService
                .open(DentistVisitDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
