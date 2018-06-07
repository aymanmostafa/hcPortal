import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs/Subscription';
import { JhiEventManager } from 'ng-jhipster';

import { UserDetails } from './user-details.model';
import { UserDetailsService } from './user-details.service';

@Component({
    selector: 'jhi-user-details-detail',
    templateUrl: './user-details-detail.component.html'
})
export class UserDetailsDetailComponent implements OnInit, OnDestroy {

    userDetails: UserDetails;
    private subscription: Subscription;
    private eventSubscriber: Subscription;

    constructor(
        private eventManager: JhiEventManager,
        private userDetailsService: UserDetailsService,
        private route: ActivatedRoute
    ) {
    }

    ngOnInit() {
        this.subscription = this.route.params.subscribe((params) => {
            this.load(params['id']);
        });
        this.registerChangeInUserDetails();
    }

    load(id) {
        this.userDetailsService.find(id)
            .subscribe((userDetailsResponse: HttpResponse<UserDetails>) => {
                this.userDetails = userDetailsResponse.body;
            });
    }
    previousState() {
        window.history.back();
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
        this.eventManager.destroy(this.eventSubscriber);
    }

    registerChangeInUserDetails() {
        this.eventSubscriber = this.eventManager.subscribe(
            'userDetailsListModification',
            (response) => this.load(this.userDetails.id)
        );
    }
}
