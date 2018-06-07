/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { DiabetesSugarTestDialogComponent } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test-dialog.component';
import { DiabetesSugarTestService } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.service';
import { DiabetesSugarTest } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.model';

describe('Component Tests', () => {

    describe('DiabetesSugarTest Management Dialog Component', () => {
        let comp: DiabetesSugarTestDialogComponent;
        let fixture: ComponentFixture<DiabetesSugarTestDialogComponent>;
        let service: DiabetesSugarTestService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DiabetesSugarTestDialogComponent],
                providers: [
                    DiabetesSugarTestService
                ]
            })
            .overrideTemplate(DiabetesSugarTestDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DiabetesSugarTestDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DiabetesSugarTestService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('save', () => {
            it('Should call update service on save for existing entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new DiabetesSugarTest('123');
                        spyOn(service, 'update').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.diabetesSugarTest = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.update).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'diabetesSugarTestListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );

            it('Should call create service on save for new entity',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        const entity = new DiabetesSugarTest();
                        spyOn(service, 'create').and.returnValue(Observable.of(new HttpResponse({body: entity})));
                        comp.diabetesSugarTest = entity;
                        // WHEN
                        comp.save();
                        tick(); // simulate async

                        // THEN
                        expect(service.create).toHaveBeenCalledWith(entity);
                        expect(comp.isSaving).toEqual(false);
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalledWith({ name: 'diabetesSugarTestListModification', content: 'OK'});
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
