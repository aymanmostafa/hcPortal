import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    DentistNextVisitService,
    DentistNextVisitPopupService,
    DentistNextVisitComponent,
    DentistNextVisitDetailComponent,
    DentistNextVisitDialogComponent,
    DentistNextVisitPopupComponent,
    DentistNextVisitDeletePopupComponent,
    DentistNextVisitDeleteDialogComponent,
    dentistNextVisitRoute,
    dentistNextVisitPopupRoute,
    DentistNextVisitResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...dentistNextVisitRoute,
    ...dentistNextVisitPopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        DentistNextVisitComponent,
        DentistNextVisitDetailComponent,
        DentistNextVisitDialogComponent,
        DentistNextVisitDeleteDialogComponent,
        DentistNextVisitPopupComponent,
        DentistNextVisitDeletePopupComponent,
    ],
    entryComponents: [
        DentistNextVisitComponent,
        DentistNextVisitDialogComponent,
        DentistNextVisitPopupComponent,
        DentistNextVisitDeleteDialogComponent,
        DentistNextVisitDeletePopupComponent,
    ],
    providers: [
        DentistNextVisitService,
        DentistNextVisitPopupService,
        DentistNextVisitResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalDentistNextVisitModule {}
