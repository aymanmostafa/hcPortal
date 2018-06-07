/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { MenstrualCycleDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle-delete-dialog.component';
import { MenstrualCycleService } from '../../../../../../main/webapp/app/entities/menstrual-cycle/menstrual-cycle.service';

describe('Component Tests', () => {

    describe('MenstrualCycle Management Delete Component', () => {
        let comp: MenstrualCycleDeleteDialogComponent;
        let fixture: ComponentFixture<MenstrualCycleDeleteDialogComponent>;
        let service: MenstrualCycleService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [MenstrualCycleDeleteDialogComponent],
                providers: [
                    MenstrualCycleService
                ]
            })
            .overrideTemplate(MenstrualCycleDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(MenstrualCycleDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(MenstrualCycleService);
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
