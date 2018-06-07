/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsRespiratoryRateDialogComponent } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate-dialog.component';
import { VsRespiratoryRateService } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate.service';
import { VsRespiratoryRate } from '../../../../../../main/webapp/app/entities/vs-respiratory-rate/vs-respiratory-rate.model';

describe('Component Tests', () => {

    describe('VsRespiratoryRate Management Dialog Component', () => {
        let comp: VsRespiratoryRateDialogComponent;
        let fixture: ComponentFixture<VsRespiratoryRateDialogComponent>;
        let service: VsRespiratoryRateService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsRespiratoryRateDialogComponent],
                providers: [
                    VsRespiratoryRateService
                ]
            })
            .overrideTemplate(VsRespiratoryRateDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsRespiratoryRateDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsRespiratoryRateService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new VsRespiratoryRate('123');
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.vsRespiratoryRate = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'vsRespiratoryRateListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new VsRespiratoryRate();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.vsRespiratoryRate = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'vsRespiratoryRateListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
