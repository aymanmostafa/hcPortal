import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { BloodTest } from './blood-test.model';
import { BloodTestPopupService } from './blood-test-popup.service';
import { BloodTestService } from './blood-test.service';

@Component({
    selector: 'jhi-blood-test-delete-dialog',
    templateUrl: './blood-test-delete-dialog.component.html'
})
export class BloodTestDeleteDialogComponent {

    bloodTest: BloodTest;

    constructor(
        private bloodTestService: BloodTestService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.bloodTestService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'bloodTestListModification',
                content: 'Deleted an bloodTest'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-blood-test-delete-popup',
    template: ''
})
export class BloodTestDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private bloodTestPopupService: BloodTestPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.bloodTestPopupService
                .open(BloodTestDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
