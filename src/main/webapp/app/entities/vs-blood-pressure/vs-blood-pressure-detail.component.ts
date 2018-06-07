import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VsBloodPressure } from './vs-blood-pressure.model';
import { VsBloodPressureService } from './vs-blood-pressure.service';

@Component({
    selector: 'jhi-vs-blood-pressure-detail',
    templateUrl: './vs-blood-pressure-detail.component.html'
})
export class VsBloodPressureDetailComponent implements OnInit, OnDestroy {

    vsBloodPressure: VsBloodPressure;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vsBloodPressureService: VsBloodPressureService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVsBloodPressures();
    }

    load(id) {
        this.vsBloodPressureService.find(id)
            .subscribe((vsBloodPressureResponse: HttpResponse<VsBloodPressure>) => {
                this.vsBloodPressure = vsBloodPressureResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVsBloodPressures() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vsBloodPressureListModification',
            (response) => this.load(this.vsBloodPressure.id)
        );
    }
}
