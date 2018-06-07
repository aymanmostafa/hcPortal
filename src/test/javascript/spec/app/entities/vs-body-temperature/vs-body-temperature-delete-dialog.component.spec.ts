/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsBodyTemperatureDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature-delete-dialog.component';
import { VsBodyTemperatureService } from '../../../../../../main/webapp/app/entities/vs-body-temperature/vs-body-temperature.service';

describe('Component Tests', () => {

    describe('VsBodyTemperature Management Delete Component', () => {
        let comp: VsBodyTemperatureDeleteDialogComponent;
        let fixture: ComponentFixture<VsBodyTemperatureDeleteDialogComponent>;
        let service: VsBodyTemperatureService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsBodyTemperatureDeleteDialogComponent],
                providers: [
                    VsBodyTemperatureService
                ]
            })
            .overrideTemplate(VsBodyTemperatureDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsBodyTemperatureDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsBodyTemperatureService);
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
