import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DentistNextVisit } from './dentist-next-visit.model';
import { DentistNextVisitPopupService } from './dentist-next-visit-popup.service';
import { DentistNextVisitService } from './dentist-next-visit.service';

@Component({
    selector: 'jhi-dentist-next-visit-delete-dialog',
    templateUrl: './dentist-next-visit-delete-dialog.component.html'
})
export class DentistNextVisitDeleteDialogComponent {

    dentistNextVisit: DentistNextVisit;

    constructor(
        private dentistNextVisitService: DentistNextVisitService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.dentistNextVisitService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'dentistNextVisitListModification',
                content: 'Deleted an dentistNextVisit'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-dentist-next-visit-delete-popup',
    template: ''
})
export class DentistNextVisitDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private dentistNextVisitPopupService: DentistNextVisitPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.dentistNextVisitPopupService
                .open(DentistNextVisitDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
