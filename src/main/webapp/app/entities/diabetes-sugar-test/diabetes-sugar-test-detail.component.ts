import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { DiabetesSugarTest } from './diabetes-sugar-test.model';
import { DiabetesSugarTestService } from './diabetes-sugar-test.service';

@Component({
    selector: 'jhi-diabetes-sugar-test-detail',
    templateUrl: './diabetes-sugar-test-detail.component.html'
})
export class DiabetesSugarTestDetailComponent implements OnInit, OnDestroy {

    diabetesSugarTest: DiabetesSugarTest;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private diabetesSugarTestService: DiabetesSugarTestService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDiabetesSugarTests();
    }

    load(id) {
        this.diabetesSugarTestService.find(id)
            .subscribe((diabetesSugarTestResponse: HttpResponse<DiabetesSugarTest>) => {
                this.diabetesSugarTest = diabetesSugarTestResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDiabetesSugarTests() {
        this.eventSubscriber = this.eventManager.subscribe(
            'diabetesSugarTestListModification',
            (response) => this.load(this.diabetesSugarTest.id)
        );
    }
}
