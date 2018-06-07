/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { MenstrualCycleDialogComponent } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle-dialog.component';
import { MenstrualCycleService } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.service';
import { MenstrualCycle } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.model';

describe('Component Tests', () => {

    describe('MenstrualCycle Management Dialog Component', () => {
        let comp: MenstrualCycleDialogComponent;
        let fixture: ComponentFixture<MenstrualCycleDialogComponent>;
        let service: MenstrualCycleService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [MenstrualCycleDialogComponent],
                providers: [
                    MenstrualCycleService
                ]
            })
            .overrideTemplate(MenstrualCycleDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MenstrualCycleDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MenstrualCycleService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new MenstrualCycle('123');
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.menstrualCycle = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'menstrualCycleListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new MenstrualCycle();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.menstrualCycle = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'menstrualCycleListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
