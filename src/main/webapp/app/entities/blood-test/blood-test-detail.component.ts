import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { BloodTest } from './blood-test.model';
import { BloodTestService } from './blood-test.service';

@Component({
    selector: 'jhi-blood-test-detail',
    templateUrl: './blood-test-detail.component.html'
})
export class BloodTestDetailComponent implements OnInit, OnDestroy {

    bloodTest: BloodTest;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private bloodTestService: BloodTestService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInBloodTests();
    }

    load(id) {
        this.bloodTestService.find(id)
            .subscribe((bloodTestResponse: HttpResponse<BloodTest>) => {
                this.bloodTest = bloodTestResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInBloodTests() {
        this.eventSubscriber = this.eventManager.subscribe(
            'bloodTestListModification',
            (response) => this.load(this.bloodTest.id)
        );
    }
}
