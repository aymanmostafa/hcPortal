import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { DentistNextVisit } from './dentist-next-visit.model';
import { DentistNextVisitService } from './dentist-next-visit.service';

@Component({
    selector: 'jhi-dentist-next-visit-detail',
    templateUrl: './dentist-next-visit-detail.component.html'
})
export class DentistNextVisitDetailComponent implements OnInit, OnDestroy {

    dentistNextVisit: DentistNextVisit;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private dentistNextVisitService: DentistNextVisitService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInDentistNextVisits();
    }

    load(id) {
        this.dentistNextVisitService.find(id)
            .subscribe((dentistNextVisitResponse: HttpResponse<DentistNextVisit>) => {
                this.dentistNextVisit = dentistNextVisitResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInDentistNextVisits() {
        this.eventSubscriber = this.eventManager.subscribe(
            'dentistNextVisitListModification',
            (response) => this.load(this.dentistNextVisit.id)
        );
    }
}
