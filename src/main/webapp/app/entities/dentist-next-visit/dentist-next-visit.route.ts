import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';
import { JhiPaginationUtil } from 'ng-jhipster';

import { UserRouteAccessService } from '../../shared';
import { DentistNextVisitComponent } from './dentist-next-visit.component';
import { DentistNextVisitDetailComponent } from './dentist-next-visit-detail.component';
import { DentistNextVisitPopupComponent } from './dentist-next-visit-dialog.component';
import { DentistNextVisitDeletePopupComponent } from './dentist-next-visit-delete-dialog.component';

@Injectable()
export class DentistNextVisitResolvePagingParams implements Resolve<any> {

    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : 'id,asc';
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
      };
    }
}

export const dentistNextVisitRoute: Routes = [
    {
        path: 'dentist-next-visit',
        component: DentistNextVisitComponent,
        resolve: {
            'pagingParams': DentistNextVisitResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'hcPortalApp.dentistNextVisit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'dentist-next-visit/:id',
        component: DentistNextVisitDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'hcPortalApp.dentistNextVisit.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const dentistNextVisitPopupRoute: Routes = [
    {
        path: 'dentist-next-visit-new',
        component: DentistNextVisitPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'hcPortalApp.dentistNextVisit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dentist-next-visit/:id/edit',
        component: DentistNextVisitPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'hcPortalApp.dentistNextVisit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'dentist-next-visit/:id/delete',
        component: DentistNextVisitDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'hcPortalApp.dentistNextVisit.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
