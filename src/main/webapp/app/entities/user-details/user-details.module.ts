import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    UserDetailsService,
    UserDetailsPopupService,
    UserDetailsComponent,
    UserDetailsDetailComponent,
    UserDetailsDialogComponent,
    UserDetailsPopupComponent,
    UserDetailsDeletePopupComponent,
    UserDetailsDeleteDialogComponent,
    userDetailsRoute,
    userDetailsPopupRoute,
    UserDetailsResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...userDetailsRoute,
    ...userDetailsPopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        UserDetailsComponent,
        UserDetailsDetailComponent,
        UserDetailsDialogComponent,
        UserDetailsDeleteDialogComponent,
        UserDetailsPopupComponent,
        UserDetailsDeletePopupComponent,
    ],
    entryComponents: [
        UserDetailsComponent,
        UserDetailsDialogComponent,
        UserDetailsPopupComponent,
        UserDetailsDeleteDialogComponent,
        UserDetailsDeletePopupComponent,
    ],
    providers: [
        UserDetailsService,
        UserDetailsPopupService,
        UserDetailsResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalUserDetailsModule {}
