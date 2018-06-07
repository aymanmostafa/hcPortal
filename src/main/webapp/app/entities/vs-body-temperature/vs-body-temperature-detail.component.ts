import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VsBodyTemperature } from './vs-body-temperature.model';
import { VsBodyTemperatureService } from './vs-body-temperature.service';

@Component({
    selector: 'jhi-vs-body-temperature-detail',
    templateUrl: './vs-body-temperature-detail.component.html'
})
export class VsBodyTemperatureDetailComponent implements OnInit, OnDestroy {

    vsBodyTemperature: VsBodyTemperature;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vsBodyTemperatureService: VsBodyTemperatureService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVsBodyTemperatures();
    }

    load(id) {
        this.vsBodyTemperatureService.find(id)
            .subscribe((vsBodyTemperatureResponse: HttpResponse<VsBodyTemperature>) => {
                this.vsBodyTemperature = vsBodyTemperatureResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVsBodyTemperatures() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vsBodyTemperatureListModification',
            (response) => this.load(this.vsBodyTemperature.id)
        );
    }
}
