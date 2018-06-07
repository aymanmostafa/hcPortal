import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { DiabetesSugarTest } from './diabetes-sugar-test.model';
import { DiabetesSugarTestPopupService } from './diabetes-sugar-test-popup.service';
import { DiabetesSugarTestService } from './diabetes-sugar-test.service';

@Component({
    selector: 'jhi-diabetes-sugar-test-delete-dialog',
    templateUrl: './diabetes-sugar-test-delete-dialog.component.html'
})
export class DiabetesSugarTestDeleteDialogComponent {

    diabetesSugarTest: DiabetesSugarTest;

    constructor(
        private diabetesSugarTestService: DiabetesSugarTestService,
        public activeModal: NgbActiveModal,
        private eventManager: JhiEventManager
    ) {
    }

    clear() {
        this.activeModal.dismiss('cancel');
    }

    confirmDelete(id: string) {
        this.diabetesSugarTestService.delete(id).subscribe((response) => {
            this.eventManager.broadcast({
                name: 'diabetesSugarTestListModification',
                content: 'Deleted an diabetesSugarTest'
            });
            this.activeModal.dismiss(true);
        });
    }
}

@Component({
    selector: 'jhi-diabetes-sugar-test-delete-popup',
    template: ''
})
export class DiabetesSugarTestDeletePopupComponent implements OnInit, OnDestroy {

    routeSub: any;

    constructor(
        private route: ActivatedRoute,
        private diabetesSugarTestPopupService: DiabetesSugarTestPopupService
    ) {}

    ngOnInit() {
        this.routeSub = this.route.params.subscribe((params) => {
            this.diabetesSugarTestPopupService
                .open(DiabetesSugarTestDeleteDialogComponent as Component, params['id']);
        });
    }

    ngOnDestroy() {
        this.routeSub.unsubscribe();
    }
}
