import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VsRespiratoryRate } from './vs-respiratory-rate.model';
import { VsRespiratoryRateService } from './vs-respiratory-rate.service';

@Component({
    selector: 'jhi-vs-respiratory-rate-detail',
    templateUrl: './vs-respiratory-rate-detail.component.html'
})
export class VsRespiratoryRateDetailComponent implements OnInit, OnDestroy {

    vsRespiratoryRate: VsRespiratoryRate;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vsRespiratoryRateService: VsRespiratoryRateService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVsRespiratoryRates();
    }

    load(id) {
        this.vsRespiratoryRateService.find(id)
            .subscribe((vsRespiratoryRateResponse: HttpResponse<VsRespiratoryRate>) => {
                this.vsRespiratoryRate = vsRespiratoryRateResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVsRespiratoryRates() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vsRespiratoryRateListModification',
            (response) => this.load(this.vsRespiratoryRate.id)
        );
    }
}
