import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    VsBodyTemperatureService,
    VsBodyTemperaturePopupService,
    VsBodyTemperatureComponent,
    VsBodyTemperatureDetailComponent,
    VsBodyTemperatureDialogComponent,
    VsBodyTemperaturePopupComponent,
    VsBodyTemperatureDeletePopupComponent,
    VsBodyTemperatureDeleteDialogComponent,
    vsBodyTemperatureRoute,
    vsBodyTemperaturePopupRoute,
    VsBodyTemperatureResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...vsBodyTemperatureRoute,
    ...vsBodyTemperaturePopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        VsBodyTemperatureComponent,
        VsBodyTemperatureDetailComponent,
        VsBodyTemperatureDialogComponent,
        VsBodyTemperatureDeleteDialogComponent,
        VsBodyTemperaturePopupComponent,
        VsBodyTemperatureDeletePopupComponent,
    ],
    entryComponents: [
        VsBodyTemperatureComponent,
        VsBodyTemperatureDialogComponent,
        VsBodyTemperaturePopupComponent,
        VsBodyTemperatureDeleteDialogComponent,
        VsBodyTemperatureDeletePopupComponent,
    ],
    providers: [
        VsBodyTemperatureService,
        VsBodyTemperaturePopupService,
        VsBodyTemperatureResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalVsBodyTemperatureModule {}
