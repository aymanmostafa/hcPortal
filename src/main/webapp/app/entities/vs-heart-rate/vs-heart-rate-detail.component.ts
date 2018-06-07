import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VsHeartRate } from './vs-heart-rate.model';
import { VsHeartRateService } from './vs-heart-rate.service';

@Component({
    selector: 'jhi-vs-heart-rate-detail',
    templateUrl: './vs-heart-rate-detail.component.html'
})
export class VsHeartRateDetailComponent implements OnInit, OnDestroy {

    vsHeartRate: VsHeartRate;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vsHeartRateService: VsHeartRateService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVsHeartRates();
    }

    load(id) {
        this.vsHeartRateService.find(id)
            .subscribe((vsHeartRateResponse: HttpResponse<VsHeartRate>) => {
                this.vsHeartRate = vsHeartRateResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVsHeartRates() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vsHeartRateListModification',
            (response) => this.load(this.vsHeartRate.id)
        );
    }
}
