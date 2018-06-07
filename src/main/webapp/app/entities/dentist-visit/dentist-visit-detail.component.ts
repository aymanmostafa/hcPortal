import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { DentistVisit } from './dentist-visit.model';
import { DentistVisitService } from './dentist-visit.service';

@Component({
    selector: 'jhi-dentist-visit-detail',
    templateUrl: './dentist-visit-detail.component.html'
})
export class DentistVisitDetailComponent implements OnInit, OnDestroy {

    dentistVisit: DentistVisit;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private dentistVisitService: DentistVisitService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDentistVisits();
    }

    load(id) {
        this.dentistVisitService.find(id)
            .subscribe((dentistVisitResponse: HttpResponse<DentistVisit>) => {
                this.dentistVisit = dentistVisitResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDentistVisits() {
        this.eventSubscriber = this.eventManager.subscribe(
            'dentistVisitListModification',
            (response) => this.load(this.dentistVisit.id)
        );
    }
}
