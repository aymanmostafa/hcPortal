import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { MenstrualCycle } from './menstrual-cycle.model';
import { MenstrualCycleService } from './menstrual-cycle.service';

@Component({
    selector: 'jhi-menstrual-cycle-detail',
    templateUrl: './menstrual-cycle-detail.component.html'
})
export class MenstrualCycleDetailComponent implements OnInit, OnDestroy {

    menstrualCycle: MenstrualCycle;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private menstrualCycleService: MenstrualCycleService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInMenstrualCycles();
    }

    load(id) {
        this.menstrualCycleService.find(id)
            .subscribe((menstrualCycleResponse: HttpResponse<MenstrualCycle>) => {
                this.menstrualCycle = menstrualCycleResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInMenstrualCycles() {
        this.eventSubscriber = this.eventManager.subscribe(
            'menstrualCycleListModification',
            (response) => this.load(this.menstrualCycle.id)
        );
    }
}
