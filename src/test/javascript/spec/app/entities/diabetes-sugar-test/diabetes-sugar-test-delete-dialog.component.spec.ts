/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { DiabetesSugarTestDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test-delete-dialog.component';
import { DiabetesSugarTestService } from '../../../../../../main/webapp/app/entities/diabetes-sugar-test/diabetes-sugar-test.service';

describe('Component Tests', () => {

    describe('DiabetesSugarTest Management Delete Component', () => {
        let comp: DiabetesSugarTestDeleteDialogComponent;
        let fixture: ComponentFixture<DiabetesSugarTestDeleteDialogComponent>;
        let service: DiabetesSugarTestService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DiabetesSugarTestDeleteDialogComponent],
                providers: [
                    DiabetesSugarTestService
                ]
            })
            .overrideTemplate(DiabetesSugarTestDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DiabetesSugarTestDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DiabetesSugarTestService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete',
                inject([],
                    fakeAsync(() => {
                        // GIVEN
                        spyOn(service, 'delete').and.returnValue(Observable.of({}));

                        // WHEN
                        comp.confirmDelete('123');
                        tick();

                        // THEN
                        expect(service.delete).toHaveBeenCalledWith('123');
                        expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                        expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                    })
                )
            );
        });
    });

});
