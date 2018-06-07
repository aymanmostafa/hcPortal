import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { VsSpo2 } from './vs-spo-2.model';
import { VsSpo2Service } from './vs-spo-2.service';

@Component({
    selector: 'jhi-vs-spo-2-detail',
    templateUrl: './vs-spo-2-detail.component.html'
})
export class VsSpo2DetailComponent implements OnInit, OnDestroy {

    vsSpo2: VsSpo2;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private vsSpo2Service: VsSpo2Service,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInVsSpo2S();
    }

    load(id) {
        this.vsSpo2Service.find(id)
            .subscribe((vsSpo2Response: HttpResponse<VsSpo2>) => {
                this.vsSpo2 = vsSpo2Response.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInVsSpo2S() {
        this.eventSubscriber = this.eventManager.subscribe(
            'vsSpo2ListModification',
            (response) => this.load(this.vsSpo2.id)
        );
    }
}
