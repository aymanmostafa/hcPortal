import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    VsRespiratoryRateService,
    VsRespiratoryRatePopupService,
    VsRespiratoryRateComponent,
    VsRespiratoryRateDetailComponent,
    VsRespiratoryRateDialogComponent,
    VsRespiratoryRatePopupComponent,
    VsRespiratoryRateDeletePopupComponent,
    VsRespiratoryRateDeleteDialogComponent,
    vsRespiratoryRateRoute,
    vsRespiratoryRatePopupRoute,
    VsRespiratoryRateResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...vsRespiratoryRateRoute,
    ...vsRespiratoryRatePopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        VsRespiratoryRateComponent,
        VsRespiratoryRateDetailComponent,
        VsRespiratoryRateDialogComponent,
        VsRespiratoryRateDeleteDialogComponent,
        VsRespiratoryRatePopupComponent,
        VsRespiratoryRateDeletePopupComponent,
    ],
    entryComponents: [
        VsRespiratoryRateComponent,
        VsRespiratoryRateDialogComponent,
        VsRespiratoryRatePopupComponent,
        VsRespiratoryRateDeleteDialogComponent,
        VsRespiratoryRateDeletePopupComponent,
    ],
    providers: [
        VsRespiratoryRateService,
        VsRespiratoryRatePopupService,
        VsRespiratoryRateResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalVsRespiratoryRateModule {}
