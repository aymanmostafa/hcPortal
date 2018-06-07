import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { HcPortalSharedModule } from '../../shared';
import {
    DiabetesSugarTestService,
    DiabetesSugarTestPopupService,
    DiabetesSugarTestComponent,
    DiabetesSugarTestDetailComponent,
    DiabetesSugarTestDialogComponent,
    DiabetesSugarTestPopupComponent,
    DiabetesSugarTestDeletePopupComponent,
    DiabetesSugarTestDeleteDialogComponent,
    diabetesSugarTestRoute,
    diabetesSugarTestPopupRoute,
    DiabetesSugarTestResolvePagingParams,
} from './';

const ENTITY_STATES = [
    ...diabetesSugarTestRoute,
    ...diabetesSugarTestPopupRoute,
];

@NgModule({
    imports: [
        HcPortalSharedModule,
        RouterModule.forChild(ENTITY_STATES)
    ],
    declarations: [
        DiabetesSugarTestComponent,
        DiabetesSugarTestDetailComponent,
        DiabetesSugarTestDialogComponent,
        DiabetesSugarTestDeleteDialogComponent,
        DiabetesSugarTestPopupComponent,
        DiabetesSugarTestDeletePopupComponent,
    ],
    entryComponents: [
        DiabetesSugarTestComponent,
        DiabetesSugarTestDialogComponent,
        DiabetesSugarTestPopupComponent,
        DiabetesSugarTestDeleteDialogComponent,
        DiabetesSugarTestDeletePopupComponent,
    ],
    providers: [
        DiabetesSugarTestService,
        DiabetesSugarTestPopupService,
        DiabetesSugarTestResolvePagingParams,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class HcPortalDiabetesSugarTestModule {}
