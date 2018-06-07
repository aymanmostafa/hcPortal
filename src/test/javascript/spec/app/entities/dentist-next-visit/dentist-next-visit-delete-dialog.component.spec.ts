/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, async, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable } from 'rxjs/Observable';
import { JhiEventManager } from 'ng-jhipster';

import { HcPortalTestModule } from '../../../test.module';
import { DentistNextVisitDeleteDialogComponent } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit-delete-dialog.component';
import { DentistNextVisitService } from '../../../../../../main/webapp/app/entities/dentist-next-visit/dentist-next-visit.service';

describe('Component Tests', () => {

    describe('DentistNextVisit Management Delete Component', () => {
        let comp: DentistNextVisitDeleteDialogComponent;
        let fixture: ComponentFixture<DentistNextVisitDeleteDialogComponent>;
        let service: DentistNextVisitService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(async(() => {
            TestBed.configureTestingModule({
                imports: [HcPortalTestModule],
                declarations: [DentistNextVisitDeleteDialogComponent],
                providers: [
                    DentistNextVisitService
                ]
            })
            .overrideTemplate(DentistNextVisitDeleteDialogComponent, '')
            .compileComponents();
        }));

        beforeEach(() => {
            fixture = TestBed.createComponent(DentistNextVisitDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(DentistNextVisitService);
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
