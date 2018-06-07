import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    VsBloodPressureService,
    VsBloodPressurePopupService,
    VsBloodPressureComponent,
    VsBloodPressureDetailComponent,
    VsBloodPressureDialogComponent,
    VsBloodPressurePopupComponent,
    VsBloodPressureDeletePopupComponent,
    VsBloodPressureDeleteDialogComponent,
    vsBloodPressureRoute,
    vsBloodPressurePopupRoute,
    VsBloodPressureResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...vsBloodPressureRoute,
    ...vsBloodPressurePopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        VsBloodPressureComponent,
        VsBloodPressureDetailComponent,
        VsBloodPressureDialogComponent,
        VsBloodPressureDeleteDialogComponent,
        VsBloodPressurePopupComponent,
        VsBloodPressureDeletePopupComponent,
    ],
    entryComponents: [
        VsBloodPressureComponent,
        VsBloodPressureDialogComponent,
        VsBloodPressurePopupComponent,
        VsBloodPressureDeleteDialogComponent,
        VsBloodPressureDeletePopupComponent,
    ],
    providers: [
        VsBloodPressureService,
        VsBloodPressurePopupService,
        VsBloodPressureResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalVsBloodPressureModule {}
