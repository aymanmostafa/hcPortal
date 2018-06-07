/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsBloodPressureDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure-delete-dialog.component';
import { VsBloodPressureService } from '../../../../../../main/webapp/app/entities/vs-blood-pressure/vs-blood-pressure.service';

describe('Component Tests', () => {

    describe('VsBloodPressure Management Delete Component', () => {
        let comp: VsBloodPressureDeleteDialogComponent;
        let fixture: ComponentFixture<VsBloodPressureDeleteDialogComponent>;
        let service: VsBloodPressureService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBloodPressureDeleteDialogComponent],
                providers: [
                    VsBloodPressureService
                ]
            })
            .overrideTemplate(VsBloodPressureDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBloodPressureDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBloodPressureService);
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
