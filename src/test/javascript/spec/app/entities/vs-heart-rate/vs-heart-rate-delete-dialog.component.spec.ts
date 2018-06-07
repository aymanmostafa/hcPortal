/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { VsHeartRateDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate-delete-dialog.component';
import { VsHeartRateService } from '../../../../../../main/webapp/app/entities/vs-heart-rate/vs-heart-rate.service';

describe('Component Tests', () => {

    describe('VsHeartRate Management Delete Component', () => {
        let comp: VsHeartRateDeleteDialogComponent;
        let fixture: ComponentFixture<VsHeartRateDeleteDialogComponent>;
        let service: VsHeartRateService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [VsHeartRateDeleteDialogComponent],
                providers: [
                    VsHeartRateService
                ]
            })
            .overrideTemplate(VsHeartRateDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(VsHeartRateDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(VsHeartRateService);
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
