/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsBodyTemperatureDialogComponent } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature-dialog.component';
import { VsBodyTemperatureService } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.service';
import { VsBodyTemperature } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.model';

describe('Component Tests', () => {

    describe('VsBodyTemperature Management Dialog Component', () => {
        let comp: VsBodyTemperatureDialogComponent;
        let fixture: ComponentFixture<VsBodyTemperatureDialogComponent>;
        let service: VsBodyTemperatureService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBodyTemperatureDialogComponent],
                providers: [
                    VsBodyTemperatureService
                ]
            })
            .overrideTemplate(VsBodyTemperatureDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBodyTemperatureDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBodyTemperatureService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new VsBodyTemperature('123');
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.vsBodyTemperature = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'vsBodyTemperatureListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new VsBodyTemperature();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.vsBodyTemperature = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'vsBodyTemperatureListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
