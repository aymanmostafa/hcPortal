/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsSpo2DeleteDialogComponent } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2-delete-dialog.component';
import { VsSpo2Service } from '../../../../../../main/webapp/app/entities/vs-spo-2/vs-spo-2.service';

describe('Component Tests', () => {

    describe('VsSpo2 Management Delete Component', () => {
        let comp: VsSpo2DeleteDialogComponent;
        let fixture: ComponentFixture<VsSpo2DeleteDialogComponent>;
        let service: VsSpo2Service;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsSpo2DeleteDialogComponent],
                providers: [
                    VsSpo2Service
                ]
            })
            .overrideTemplate(VsSpo2DeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsSpo2DeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsSpo2Service);
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
