/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { DentistVisitDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit-delete-dialog.component';
import { DentistVisitService } from '../../../../../../main/webapp/app/entities/dentist-visit/dentist-visit.service';

describe('Component Tests', () => {

    describe('DentistVisit Management Delete Component', () => {
        let comp: DentistVisitDeleteDialogComponent;
        let fixture: ComponentFixture<DentistVisitDeleteDialogComponent>;
        let service: DentistVisitService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistVisitDeleteDialogComponent],
                providers: [
                    DentistVisitService
                ]
            })
            .overrideTemplate(DentistVisitDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistVisitDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistVisitService);
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
